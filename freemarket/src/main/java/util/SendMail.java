package util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * メール送信クラス
 */
public class SendMail {
	public static void sendBuyerMail (String email, String name, String price, String nickname) {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
					props,
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							//メールサーバにログインするメールアドレスとパスワードを設定
							return new PasswordAuthentication("test.sender@kanda-it-school-system.com",
									"kandaSender202208");
						}
					});

			MimeMessage mimeMessage = new MimeMessage(session);
			//各種情報
			String sender = "神田IT School";
			String senderAddress = "test.sender@kanda-it-school-system.com";
			String recipient = email;
			String subject = "ご購入のお知らせ";
			String header = "Content-Type";
			
			
			//メール本文
			StringBuilder text = new StringBuilder();
			text.append(nickname + "様\n\n");
			text.append(name + "のご購入がされました。。\n");
			text.append("ご連絡致します。\n\n");			

			text.append("  " + price + "円\n\n");
			text.append("よろしくお願いします。");

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(
					new InternetAddress(senderAddress, sender, "iso-2022-jp"));

			// 送信先メールアドレスを指定（ご自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, recipient);

			// メールのタイトルを指定
			mimeMessage.setSubject(subject, "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(text.toString(), "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader(header, "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
	
	public static void sendMemberMail (String email, String name, String price, String nickname) {
		try {
			Properties props = System.getProperties();

			// SMTPサーバのアドレスを指定（今回はxserverのSMTPサーバを利用）
			props.put("mail.smtp.host", "sv5215.xserver.jp");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", "587");
			props.put("mail.smtp.debug", "true");

			Session session = Session.getInstance(
					props,
					new javax.mail.Authenticator() {
						@Override
						protected PasswordAuthentication getPasswordAuthentication() {
							//メールサーバにログインするメールアドレスとパスワードを設定
							return new PasswordAuthentication("test.sender@kanda-it-school-system.com",
									"kandaSender202208");
						}
					});

			MimeMessage mimeMessage = new MimeMessage(session);
			//各種情報
			String sender = "神田IT School";
			String senderAddress = "test.sender@kanda-it-school-system.com";
			String recipient = email;
			String subject = "ご購入のお知らせ";
			String header = "Content-Type";
			
			
			//メール本文
			StringBuilder text = new StringBuilder();
			text.append(nickname + "様\n\n");
			text.append(name + "をご購入しました。。\n");
			text.append("ご連絡致します。\n\n");			

			text.append("  " + price + "円\n\n");
			text.append("よろしくお願いします。");

			// 送信元メールアドレスと送信者名を指定
			mimeMessage.setFrom(
					new InternetAddress(senderAddress, sender, "iso-2022-jp"));

			// 送信先メールアドレスを指定（ご自分のメールアドレスに変更）
			mimeMessage.setRecipients(Message.RecipientType.TO, recipient);

			// メールのタイトルを指定
			mimeMessage.setSubject(subject, "iso-2022-jp");

			// メールの内容を指定
			mimeMessage.setText(text.toString(), "iso-2022-jp");

			// メールの形式を指定
			mimeMessage.setHeader(header, "text/plain; charset=iso-2022-jp");

			// 送信日付を指定
			mimeMessage.setSentDate(new Date());

			// 送信します
			Transport.send(mimeMessage);

			// 送信成功
			System.out.println("送信に成功しました。");

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("送信に失敗しました。\n" + e);
		}
	}
}
