package shared.model.initialized_info;

import java.util.ArrayList;
import java.util.List;

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

        _trainCards.add(_1);
        _trainCards.add(_2);
        _trainCards.add(_3);
        _trainCards.add(_4);
        _trainCards.add(_5);
        _trainCards.add(_6);
        _trainCards.add(_7);
        _trainCards.add(_8);
        _trainCards.add(_9);
        _trainCards.add(_10);
        _trainCards.add(_11);
        _trainCards.add(_12);
        _trainCards.add(_13);
        _trainCards.add(_14);

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

        _trainCards.add(_1Pink);
        _trainCards.add(_2Pink);
        _trainCards.add(_3Pink);
        _trainCards.add(_4Pink);
        _trainCards.add(_5Pink);
        _trainCards.add(_6Pink);
        _trainCards.add(_7Pink);
        _trainCards.add(_8Pink);
        _trainCards.add(_9Pink);
        _trainCards.add(_10Pink);
        _trainCards.add(_11Pink);
        _trainCards.add(_12Pink);

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

        _trainCards.add(_1Red);
        _trainCards.add(_2Red);
        _trainCards.add(_3Red);
        _trainCards.add(_4Red);
        _trainCards.add(_5Red);
        _trainCards.add(_6Red);
        _trainCards.add(_7Red);
        _trainCards.add(_8Red);
        _trainCards.add(_9Red);
        _trainCards.add(_10Red);
        _trainCards.add(_11Red);
        _trainCards.add(_12Red);

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

        _trainCards.add(_1Blue);
        _trainCards.add(_2Blue);
        _trainCards.add(_3Blue);
        _trainCards.add(_4Blue);
        _trainCards.add(_5Blue);
        _trainCards.add(_6Blue);
        _trainCards.add(_7Blue);
        _trainCards.add(_8Blue);
        _trainCards.add(_9Blue);
        _trainCards.add(_10Blue);
        _trainCards.add(_11Blue);
        _trainCards.add(_12Blue);

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

        _trainCards.add(_1Orange);
        _trainCards.add(_2Orange);
        _trainCards.add(_3Orange);
        _trainCards.add(_4Orange);
        _trainCards.add(_5Orange);
        _trainCards.add(_6Orange);
        _trainCards.add(_7Orange);
        _trainCards.add(_8Orange);
        _trainCards.add(_9Orange);
        _trainCards.add(_10Orange);
        _trainCards.add(_11Orange);
        _trainCards.add(_12Orange);

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

        _trainCards.add(_1White);
        _trainCards.add(_2White);
        _trainCards.add(_3White);
        _trainCards.add(_4White);
        _trainCards.add(_5White);
        _trainCards.add(_6White);
        _trainCards.add(_7White);
        _trainCards.add(_8White);
        _trainCards.add(_9White);
        _trainCards.add(_10White);
        _trainCards.add(_11White);
        _trainCards.add(_12White);

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

        _trainCards.add(_1Black);
        _trainCards.add(_2Black);
        _trainCards.add(_3Black);
        _trainCards.add(_4Black);
        _trainCards.add(_5Black);
        _trainCards.add(_6Black);
        _trainCards.add(_7Black);
        _trainCards.add(_8Black);
        _trainCards.add(_9Black);
        _trainCards.add(_10Black);
        _trainCards.add(_11Black);
        _trainCards.add(_12Black);

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

        _trainCards.add(_1Green);
        _trainCards.add(_2Green);
        _trainCards.add(_3Green);
        _trainCards.add(_4Green);
        _trainCards.add(_5Green);
        _trainCards.add(_6Green);
        _trainCards.add(_7Green);
        _trainCards.add(_8Green);
        _trainCards.add(_9Green);
        _trainCards.add(_10Green);
        _trainCards.add(_11Green);
        _trainCards.add(_12Green);

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

        _trainCards.add(_1Yellow);
        _trainCards.add(_2Yellow);
        _trainCards.add(_3Yellow);
        _trainCards.add(_4Yellow);
        _trainCards.add(_5Yellow);
        _trainCards.add(_6Yellow);
        _trainCards.add(_7Yellow);
        _trainCards.add(_8Yellow);
        _trainCards.add(_9Yellow);
        _trainCards.add(_10Yellow);
        _trainCards.add(_11Yellow);
        _trainCards.add(_12Yellow);
    }
}
