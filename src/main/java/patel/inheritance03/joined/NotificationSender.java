package patel.inheritance03.joined;

public interface NotificationSender<N> {
	public Class<N> appliesTo();
	public void send(N n);
}
