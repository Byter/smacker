package com.visionarysoftwaresolutions.smacker.testData

import com.visionarysoftwaresolutions.eventr.*

class MealEventManager implements EventMediator {
    Map<Observable, Collection<Observer>> managed = [:]

    @Override
    void register(Observable observable, Observer observer) {
        if (managed.containsKey(observable)) {
            def current = managed[observable]
            current.add(observer)
        } else {
            def observers = [ observer ]
            managed[observable] = observers
        }
    }

    @Override
    void unregister(Observable observable, Observer observer) {
        if (managed.containsKey(observable)) {
            def current = managed[observable]
            current.remove(observer)
        }
    }

    @Override
    void notifyObserversForObservable(Observable observable, Event event) {
        Collection<Observer> observers = managed[observable]
        if (observers) {
            observers.each { Observer ob ->
                ob.update(event)
            }
        }
    }

    @Override
    Set<Observable> getAvailableObservables() {
        managed.keySet()
    }
}