package Library.service;

import Library.model.Notification;
import Library.model.User;

import java.util.ArrayList;
import java.util.List;

public class NotificationManager {
    private List<Notification> notifications;
    public NotificationManager(){
        this.notifications = new ArrayList<>();
    }
    public void createNotification(User recipient, String message){
        Notification notification = new Notification(message, recipient);
        addNotification(notification);
    }
    private void addNotification(Notification notification){
        this.notifications.add(notification);
    }
    public List<Notification> getNotifications(){
        return this.notifications;
    }
    public void clearNotifications(){
        this.notifications.clear();
    }
    public void removeNotification(Notification notification){
        this.notifications.remove(notification);
    }
    public List<Notification> getNotificationsForUser(User user){
        // Return all notifications for a specific user
        return this.notifications.stream().filter(notification -> notification.getRecipient().equals(user)).toList();
    }
}
