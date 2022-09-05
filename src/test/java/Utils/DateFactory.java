package Utils;

import com.github.javafaker.Faker;
import enums.*;
import models.*;

public class DateFactory {

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
                .bikeBrand(BikeBrand.BMC)
                .model(String.valueOf(faker.name().name()))
                .cost("600.00")
                .date("11/20/2022")
                .distance("60.15")
                .build();
    }

    public static DatePeriod getDatePeriod() {
        return DatePeriod.builder()
                .startDate("9/05/2022")
                .endDate("9/25/2022")
                .build();
    }

    public static Report getReportInform() {
        return Report.builder()
                .startDate("9/05/2022")
                .endDate("9/10/2022")
                .activityType(ActiveType.STRENGTH_TRAINING)
                .build();
    }
}