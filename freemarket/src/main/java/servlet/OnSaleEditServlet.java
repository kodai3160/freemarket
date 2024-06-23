package servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bean.ProductionInfo;
import dao.ProductionInfoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/onSaleEdit")
@MultipartConfig
public class OnSaleEditServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String error = "";
		String check = "";

		try {
			// 入力データの文字コードの指定
			request.setCharacterEncoding("UTF-8");

			check = request.getParameter("check");
			
			if(check.equals("init")) {
				return;
			}
			
			//ProductionInfoDAOをインスタンス化
			ProductionInfoDAO productsDaoObj = new ProductionInfoDAO();

			//パラメータの取得
			String product = request.getParameter("product");
			String selling_price = request.getParameter("selling_price");
			String origin_region = request.getParameter("origin_region");
			String item_description = request.getParameter("item_description");
			//写真取得用の情報を受け取る
			Part filePart = request.getPart("image");
			String uploadDir = "";
			String filePath = "";
			String fileName = "";

			//写真取得処理
			if (filePart.getSize() != 0) {
				String contentDisposition = filePart.getHeader("content-disposition");
				Pattern pattern = Pattern.compile("filename=\"(.*)\"");
				Matcher matcher = pattern.matcher(contentDisposition);
				//抽出したファイル名が存在していれば抽出、なければ空白
				if (matcher.find()) {
					fileName = matcher.group(1);
				}else {
					fileName = "";
				}

				File file_name = new File(fileName);

				// ファイル保存先のディレクトリ
				uploadDir = getServletContext().getRealPath("/file").replace("\\", "/");
				//アップロード先のフォルダがなければ作成
				File uploadDirectory = new File(uploadDir);
				if (!uploadDirectory.exists()) {
					uploadDirectory.mkdirs();
				}

				// ファイルを指定されたディレクトリに保存
				// （具体的には以下の階層に保存される）
				// C:\ usr\kis_java_pkg_2023\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
				filePath = uploadDir + "/" + file_name.getName();
				try (InputStream inputStream = filePart.getInputStream()) {
					Files.copy(inputStream, new File(filePath).toPath(),StandardCopyOption.REPLACE_EXISTING);
				}
			}
			//空白チェック
			if (product.equals("")) {
				error = "商品名が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (selling_price.equals("")) {
				error = "価格が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (origin_region.equals("")) {
				error = "出品地域が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}
			if (item_description.equals("")) {
				error = "商品説明が未入力のため、商品情報の編集は行えませんでした。";

				return;
			}

			//ProductionInfoオブジェクト生成、セッターメソッドで設定
			ProductionInfo productionInfo = new ProductionInfo();
			productionInfo.setProduct(product);
			productionInfo.setSelling_price(selling_price);
			productionInfo.setOrigin_region(origin_region);
			productionInfo.setItem_description(item_description);
			productionInfo.setPicture("/freemarket/file/"+fileName);

			//商品情報を変更するメソッド呼び出し、ArrayListへ格納
			productsDaoObj.update(productionInfo);

			//リクエストスコープに登録
			request.setAttribute("productionInfo", productionInfo);

		} catch (IllegalStateException e) {
			error = "DB接続エラーの為、商品一覧表示は行えませんでした。";
		} finally {
			//エラーの有無でフォワード先を呼び分ける
			if(check.equals("init")) {
				request.getRequestDispatcher("/view/onSaleEdit.jsp").forward(request, response);
			}else if (error.equals("")) {
				//エラーが無い場合はユーザー情報にフォワード
				request.getRequestDispatcher("/userInformation").forward(request, response);
			} else {
				//エラーが有る場合はerror.jspにフォワードする
				request.setAttribute("error", error);
				request.getRequestDispatcher("/view/error.jsp").forward(request, response);
			}
		}

	}

}
