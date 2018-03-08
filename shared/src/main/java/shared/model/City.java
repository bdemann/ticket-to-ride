package shared.model;

import java.awt.Point;
import java.io.Serializable;

/**
 * Created by paulinecausse on 3/2/18.
 */

public class City implements Serializable {
    private CityPoint _coordinates;
    private String _name;

    public City(CityPoint coordinates, String name){
        this._coordinates = coordinates;
        this._name = name;
    }

    public CityPoint get_coordinates() {
        return _coordinates;
    }

    public String get_name() {
        return _name;
    }

}
