package menu.domain;

import java.util.List;

public class CoachesNonEdibleMenus {
    private final List<NonEdibleMenusByCoach> coachesNonEdibleMenus;

    public CoachesNonEdibleMenus(List<NonEdibleMenusByCoach> coachesNonEdibleMenus) {
        this.coachesNonEdibleMenus = coachesNonEdibleMenus;
    }

    public List<NonEdibleMenusByCoach> getCoachesNonEdibleMenus() {
        return coachesNonEdibleMenus;
    }
}
