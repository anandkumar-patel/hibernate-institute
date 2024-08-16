package patel.inheritance03.joined;

public class SMSNotificationSender implements NotificationSender<SMSNotification>{

	@Override
	public Class<SMSNotification> appliesTo() {
		return SMSNotification.class;
	}

	@Override
	public void send(SMSNotification sms) {
		System.out.println(sms.getFirstName()+" : "+sms.getPhoneNumber());
	}

}
