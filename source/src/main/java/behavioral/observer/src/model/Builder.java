package behavioral.observer.src.model;

import behavioral.observer.api.Observer;
import behavioral.observer.api.View;
import behavioral.observer.src.StatusData;

/**
 * Created by vicboma on 03/06/14.
 */
public class Builder<E extends Observer> {
    protected StatusData<E> statusData;
    protected Properties properties; 
    protected View view;
    
    public Builder (Properties properties, StatusData<E> statusData, View view) {
        this.statusData = statusData;
        this.properties = properties;
        this.view = view;
    }

}
