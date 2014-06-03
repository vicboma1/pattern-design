package behavioral.observer.src;

import behavioral.observer.api.Observer;

import java.util.*;

/**
 * Created by vicboma on 03/06/14.
 */
public abstract class Observable<E extends Observer >  {
    protected List<E> observers = new LinkedList<E>();

    public Boolean add(E observer)
    {
        final boolean isAdd = this.observers.add(observer);
        return isAdd;
    }

    public Boolean remove(E observer)
    {
        final boolean isRemove  = this.observers.remove(observer);
        return isRemove;
    }

    private E get(Integer index)
    {
        final E element = this.observers.get(index);
        return element;
    }

    public void notification(Integer attack, Integer health, String name)
    {
       // this.observers.forEach((k,v) -> v.update());
    	final int size = this.observers.size();
    	for(int i = 0 ; i < size ; i++)
    	{
    		 final E element = get(i);
    		 element.update(attack,health,name);
    	}
    	
    	System.out.println();
    }

}
