package patel.inheritance03.joined;

public class EmailNotificationSender implements NotificationSender<EmailNotification> {

	@Override
	public Class<EmailNotification> appliesTo() {
		return EmailNotification.class;
	}

	@Override
	public void send(EmailNotification email) {
		System.out.println(email.getFirstName()+" : "+email.getEmail());
	}

}
