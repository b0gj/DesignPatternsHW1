package ObserverInterfaces;

public interface IObserver {
    void update();
    void setObservable(IObservable observable);
}
