import java.util.ArrayList;
import java.util.List;

// Интерфейс оповещателя
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers(String notification);
}

// Интерфейс наблюдателя
interface Observer {
    void update(String notification);
}

//реализация оповещателя
class Group implements Subject {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String notification) {
        for (Observer observer : observers) {
            observer.update(notification);
        }
    }
}

// реализация наблюдателя
class User implements Observer {
    private String name;


    public User(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    @Override
    public void update(String notification) {
        System.out.println(name + ", Внимание!: " + notification);
    }
}

public class Main {
    public static void main(String[] args) {
        // Создаем группы
        Group group1 = new Group();
        Group group2 = new Group();
        Group group3 = new Group();
        Group group4 = new Group();

        // Создаем пользователей
        User user1 = new User("Ванек");
        User user2 = new User("Санек");

        // Подписываем пользователей на группы
        group1.addObserver(user1);
        group2.addObserver(user1);
        group3.addObserver(user1);

        group1.addObserver(user2);
        group2.addObserver(user2);
        group3.addObserver(user2);
        group4.addObserver(user2);

        // Оповещаем о новых событиях в группах
        group1.notifyObservers("Новое оповещение в группе 1");
        group2.notifyObservers("Новое оповещение в группе 2");
        group3.notifyObservers("Новое оповещение в группе 3");
        group4.notifyObservers("Новое оповещение в группе 4");
    }
}
