package jjh.api.designPatterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BuilderTest {
    @Data
    @AllArgsConstructor
    class Mobile {
        private final int ram;
        private final int storage;
        private final int battery;
        private final int camera;
        private final String processor;
        private final double screenSize;

        private Mobile(MobileBuilder builder) {
            this.ram = builder.ram;
            this.storage = builder.storage;
            this.battery = builder.battery;
            this.camera = builder.camera;
            this.processor = builder.processor;
            this.screenSize = builder.screenSize;
        }
    }
    @Data class MobileBuilder {
        private int ram;
        private int storage;
        private int battery;
        private int camera;
        private String processor;
        private double screenSize;

        public MobileBuilder with(Consumer<MobileBuilder> buildField){
            buildField.accept(this);
            return this;
        }
        public Mobile createBuild(){
            return new Mobile(this);
        }
    }

    @Test @DisplayName("빌더패턴")
    void main() {
        MobileBuilder mobileBuilder = new MobileBuilder();
        Mobile mobile = mobileBuilder.with(myBuilder -> {
            myBuilder.ram = 4;
        }).createBuild();

        assertThat(mobile.getRam(), is(4));
    }
}