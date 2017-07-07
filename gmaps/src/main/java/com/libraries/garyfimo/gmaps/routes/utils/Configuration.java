package com.libraries.garyfimo.gmaps.routes.utils;

/**
 * Created by gfiguerola on 6/30/17.
 */

public class Configuration {

    public final int color;
    public final int width;
    public final boolean optimize;
    public final TravelMode travelMode;

    private Configuration(final Builder builder) {
        this.color = builder.color;
        this.width = builder.width;
        this.travelMode = builder.travelMode;
        this.optimize = builder.optimize;
    }

    public static class Builder {
        private int color;
        private int width;
        private boolean optimize;
        private TravelMode travelMode;

        public Builder() {
            color = 0;
            width = 7;
            optimize = false;
            travelMode = TravelMode.walking;
        }

        public Builder(final Configuration baseConfiguration) {
            color = baseConfiguration.color;
            width = baseConfiguration.width;
            travelMode = baseConfiguration.travelMode;
            optimize = baseConfiguration.optimize;
        }

        public Builder setColor(int color) {
            this.color = color;
            return this;
        }

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setOptimize(boolean optimize) {
            this.optimize = optimize;
            return this;
        }

        public Builder setTravelMode(TravelMode travelMode) {
            this.travelMode = travelMode;
            return this;
        }

        public Configuration build() {
            return new Configuration(this);
        }
    }
}
