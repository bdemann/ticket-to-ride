package shared.model;

/**
 * Created by bdemann on 3/4/18.
 */

public class Color {

    //I think I accidentally made an enum.... but maybe if we decide to actually colors on these guys we will be glad to have the option...

    public static final Color RAINBOW = new Color("rainbow");
    public static final Color PINK = new Color("pink");
    public static final Color RED = new Color("red");
    public static final Color BLUE = new Color("blue");
    public static final Color ORANGE = new Color("orange");
    public static final Color WHITE = new Color("white");
    public static final Color BLACK = new Color("black");
    public static final Color GREEN = new Color("green");
    public static final Color YELLOW = new Color("yellow");
    public static final Color GRAY = new Color("gray");

    private String _color;

    private Color(String color) {
        this._color = color;
    }

    public boolean equals(Object o) {
        if (o instanceof Color) {
            Color c = (Color) o;
            return _color.equals(c._color);
        }
        return false;
    }
}
