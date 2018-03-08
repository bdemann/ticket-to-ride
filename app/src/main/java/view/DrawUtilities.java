package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.a340team.tickettoride.R;

import java.util.List;

import shared.model.Route;

/**
 *
 * Created by BenNelson on 3/8/18.
 */

public class DrawUtilities extends View {

    private Context _context;
    private static float strokeWidth = 10;

    public DrawUtilities(Context context) {
        super(context);
        this._context = context;

    }
    public DrawUtilities(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawUtilities(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public DrawUtilities(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public void drawRoutes(List<Route> routes, ImageView view) {
        //super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(strokeWidth);

        Bitmap gameMapBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ticket_to_ride_map_with_routes);
        Bitmap drawableBitmap = gameMapBitmap.copy(Bitmap.Config.ARGB_8888, true);

        Canvas canvas = new Canvas(drawableBitmap);
        float xOffset = -50;
        float yOffset = -55;

        for (Route route : routes) {
            float sX = route.getStart().get_coordinates().x() + xOffset;
            float sY = route.getStart().get_coordinates().y() + yOffset;
            float eX = route.getEnd().get_coordinates().x() + xOffset;
            float eY = route.getEnd().get_coordinates().y()+ yOffset;
            canvas.drawLine(sX,sY,eX,eY,paint);
        }

        view.setImageBitmap(drawableBitmap);

    }
}
