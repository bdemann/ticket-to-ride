package shared.cards;

import java.util.ArrayList;
import java.util.List;

import shared.model.DestCard;
import shared.model.TrainCard;

/**
 * Created by paulinecausse on 2/27/18.
 */

// 12 of each except for the locomotive (14)

public class TrainCards {
    private static TrainCards _instance;

    public static TrainCards instance() {

        if (_instance == null)
            _instance = new TrainCards();
        return _instance;
    }

    private TrainCards(){
        this._trainCards = new ArrayList<TrainCard>();
        set_trainCards();
    }

    private List<TrainCard> _trainCards;


    private void set_trainCards(){
        TrainCard _1 = new TrainCard("rainbow", 2);
        TrainCard _2 = new TrainCard("rainbow", 2);
        TrainCard _3 = new TrainCard("rainbow", 2);
        TrainCard _4 = new TrainCard("rainbow", 2);
        TrainCard _5 = new TrainCard("rainbow", 2);
        TrainCard _6 = new TrainCard("rainbow", 2);
        TrainCard _7 = new TrainCard("rainbow", 2);
        TrainCard _8 = new TrainCard("rainbow", 2);
        TrainCard _9 = new TrainCard("rainbow", 2);
        TrainCard _10 = new TrainCard("rainbow", 2);
        TrainCard _11 = new TrainCard("rainbow", 2);
        TrainCard _12 = new TrainCard("rainbow", 2);
        TrainCard _13 = new TrainCard("rainbow", 2);
        TrainCard _14 = new TrainCard("rainbow", 2);

        TrainCard _1Pink = new TrainCard("pink", 1);
        TrainCard _2Pink = new TrainCard("pink", 1);
        TrainCard _3Pink = new TrainCard("pink", 1);
        TrainCard _4Pink = new TrainCard("pink", 1);
        TrainCard _5Pink = new TrainCard("pink", 1);
        TrainCard _6Pink = new TrainCard("pink", 1);
        TrainCard _7Pink = new TrainCard("pink", 1);
        TrainCard _8Pink = new TrainCard("pink", 1);
        TrainCard _9Pink = new TrainCard("pink", 1);
        TrainCard _10Pink = new TrainCard("pink", 1);
        TrainCard _11Pink = new TrainCard("pink", 1);
        TrainCard _12Pink = new TrainCard("pink", 1);

        TrainCard _1Red = new TrainCard("red", 1);
        TrainCard _2Red = new TrainCard("red", 1);
        TrainCard _3Red = new TrainCard("red", 1);
        TrainCard _4Red = new TrainCard("red", 1);
        TrainCard _5Red = new TrainCard("red", 1);
        TrainCard _6Red = new TrainCard("red", 1);
        TrainCard _7Red = new TrainCard("red", 1);
        TrainCard _8Red = new TrainCard("red", 1);
        TrainCard _9Red = new TrainCard("red", 1);
        TrainCard _10Red = new TrainCard("red", 1);
        TrainCard _11Red = new TrainCard("red", 1);
        TrainCard _12Red = new TrainCard("red", 1);

        TrainCard _1Blue = new TrainCard("blue", 1);
        TrainCard _2Blue = new TrainCard("blue", 1);
        TrainCard _3Blue = new TrainCard("blue", 1);
        TrainCard _4Blue = new TrainCard("blue", 1);
        TrainCard _5Blue = new TrainCard("blue", 1);
        TrainCard _6Blue = new TrainCard("blue", 1);
        TrainCard _7Blue = new TrainCard("blue", 1);
        TrainCard _8Blue = new TrainCard("blue", 1);
        TrainCard _9Blue = new TrainCard("blue", 1);
        TrainCard _10Blue = new TrainCard("blue", 1);
        TrainCard _11Blue = new TrainCard("blue", 1);
        TrainCard _12Blue = new TrainCard("blue", 1);

        TrainCard _1Orange = new TrainCard("orange", 1);
        TrainCard _2Orange = new TrainCard("orange", 1);
        TrainCard _3Orange = new TrainCard("orange", 1);
        TrainCard _4Orange = new TrainCard("orange", 1);
        TrainCard _5Orange = new TrainCard("orange", 1);
        TrainCard _6Orange = new TrainCard("orange", 1);
        TrainCard _7Orange = new TrainCard("orange", 1);
        TrainCard _8Orange = new TrainCard("orange", 1);
        TrainCard _9Orange = new TrainCard("orange", 1);
        TrainCard _10Orange = new TrainCard("orange", 1);
        TrainCard _11Orange = new TrainCard("orange", 1);
        TrainCard _12Orange = new TrainCard("orange", 1);

        TrainCard _1White = new TrainCard("white", 1);
        TrainCard _2White = new TrainCard("white", 1);
        TrainCard _3White = new TrainCard("white", 1);
        TrainCard _4White = new TrainCard("white", 1);
        TrainCard _5White = new TrainCard("white", 1);
        TrainCard _6White = new TrainCard("white", 1);
        TrainCard _7White = new TrainCard("white", 1);
        TrainCard _8White = new TrainCard("white", 1);
        TrainCard _9White = new TrainCard("white", 1);
        TrainCard _10White = new TrainCard("white", 1);
        TrainCard _11White = new TrainCard("white", 1);
        TrainCard _12White = new TrainCard("white", 1);

        TrainCard _1Black = new TrainCard("black", 1);
        TrainCard _2Black = new TrainCard("black", 1);
        TrainCard _3Black = new TrainCard("black", 1);
        TrainCard _4Black = new TrainCard("black", 1);
        TrainCard _5Black = new TrainCard("black", 1);
        TrainCard _6Black = new TrainCard("black", 1);
        TrainCard _7Black = new TrainCard("black", 1);
        TrainCard _8Black = new TrainCard("black", 1);
        TrainCard _9Black = new TrainCard("black", 1);
        TrainCard _10Black = new TrainCard("black", 1);
        TrainCard _11Black = new TrainCard("black", 1);
        TrainCard _12Black = new TrainCard("black", 1);

        TrainCard _1Green = new TrainCard("green", 1);
        TrainCard _2Green = new TrainCard("green", 1);
        TrainCard _3Green = new TrainCard("green", 1);
        TrainCard _4Green = new TrainCard("green", 1);
        TrainCard _5Green = new TrainCard("green", 1);
        TrainCard _6Green = new TrainCard("green", 1);
        TrainCard _7Green = new TrainCard("green", 1);
        TrainCard _8Green = new TrainCard("green", 1);
        TrainCard _9Green = new TrainCard("green", 1);
        TrainCard _10Green = new TrainCard("green", 1);
        TrainCard _11Green = new TrainCard("green", 1);
        TrainCard _12Green = new TrainCard("green", 1);

        TrainCard _1Yellow = new TrainCard("yellow", 1);
        TrainCard _2Yellow = new TrainCard("yellow", 1);
        TrainCard _3Yellow = new TrainCard("yellow", 1);
        TrainCard _4Yellow = new TrainCard("yellow", 1);
        TrainCard _5Yellow = new TrainCard("yellow", 1);
        TrainCard _6Yellow = new TrainCard("yellow", 1);
        TrainCard _7Yellow = new TrainCard("yellow", 1);
        TrainCard _8Yellow = new TrainCard("yellow", 1);
        TrainCard _9Yellow = new TrainCard("yellow", 1);
        TrainCard _10Yellow = new TrainCard("yellow", 1);
        TrainCard _11Yellow = new TrainCard("yellow", 1);
        TrainCard _12Yellow = new TrainCard("yellow", 1);
    }
}
