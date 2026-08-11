package constants;

import lombok.Getter;

@Getter
public enum MainPageNavigation {
    NEWS("News"),
    WORLD_CLOCK("World Clock"),
    TIME_ZONES("Time Zones"),
    CALENDAR("Calendar"),
    WEATHER("Weather"),
    SUN_MOON_SPACE("Sun, Moon & Space"),
    TIMERS("Timers"),
    CALCULATORS("Calculators");

    private final String label;

    MainPageNavigation(String label) {
        this.label = label;
    }
}
