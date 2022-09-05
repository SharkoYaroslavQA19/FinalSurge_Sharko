package Utils;

import com.github.javafaker.Faker;
import enums.*;
import models.*;

public class TestDataHelper {

    static Faker faker = new Faker();

    public static Workout addStrengthTraining(){
        return Workout.builder()
                .timeOfDay("10:00 AM")
                .workoutName(faker.esports().game())
                .workoutDescription(faker.name().title())
                .duration("1:02:10")
                .feelingWhileTraining(FeelingWhileTraining.GREAT)
                .perceivedEffort(PerceivedEffort.MODERATE6)
                .build();
    }

    public static Bike getBikeWithAllData() {
        return Bike.builder()
                .bikeName(faker.name().title())
                .bikeBrand(BikeBrand.CUBE)
                .model(String.valueOf(faker.number().randomNumber()))
                .cost("500.75")
                .date("1/20/2022")
                .distance("60.15")
                .build();
    }

    public static DatePeriod getDatePeriod() {
        return DatePeriod.builder()
                .startDate("1/5/2022")
                .endDate("1/19/2022")
                .build();
    }
}