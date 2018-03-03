package shared.model;

import java.awt.Point;

/**
 * Created by paulinecausse on 3/2/18.
 */

public class City {
    private Point _coordinates;
    private String _name;

    public City(Point coordinates, String name){
        this._coordinates = coordinates;
        this._name = name;
    }

    public Point get_coordinates() {
        return _coordinates;
    }

    public String get_name() {
        return _name;
    }

}
