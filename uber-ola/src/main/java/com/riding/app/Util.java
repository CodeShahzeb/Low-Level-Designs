package com.riding.app;

import java.util.*;

public class Util {
    public static String ratingToString(RATING pRating) {
        if (pRating == RATING.ONE_STAR)
            return "one star";
        if (pRating == RATING.TWO_STARS)
            return "two stars";
        if (pRating == RATING.THREE_STARS)
            return "three stars";
        if (pRating == RATING.FOUR_STARS)
            return "four stars";
        if (pRating == RATING.FIVE_STARS)
            return "five stars";
        return "invalid rating";
    }

    public static boolean isHighRating(RATING pRating) {
        return pRating == RATING.FOUR_STARS || pRating == RATING.FIVE_STARS;
    }
}




