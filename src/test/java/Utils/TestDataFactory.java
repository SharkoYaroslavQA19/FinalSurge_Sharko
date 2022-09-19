package Utils;

import com.github.javafaker.Faker;
import enums.*;
import models.*;

public class TestDataFactory {

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
                .endDate("9/15/2022")
                .activityType(ActiveType.STRENGTH_TRAINING)
                .build();
    }

    public static WorkoutCalculator getIntesityInform() {
        return WorkoutCalculator.builder()
                .event(Event.MARATHON)
                .hours(String.valueOf(faker.number().numberBetween(1,8)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 10)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .build();
    }

    public static WorkoutCalculator getHansonsInform() {
        return WorkoutCalculator.builder()
                .event(Event.MARATHON)
                .hours(String.valueOf(faker.number().numberBetween(1, 8)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 10)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .temperature(String.valueOf(faker.number().numberBetween(-20, 35)))
                .temperatureType(TemperatureType.C)
                .humidity(String.valueOf(faker.number().numberBetween(0, 50)))
                .windSpeed(String.valueOf(faker.number().numberBetween(0, 50)))
                .windSpeedType(WindSpeedType.KPH)
                .build();
    }

    public static CaloricNeeds getCaloricNeedInform() {
        return CaloricNeeds.builder()
                .weightType(WeightType.KG)
                .heightType(HeightType.CENTIMETERS)
                .genderType(GenderType.MALE)
                .distTypeForCalculator(DistTypeForCalculator.KILOMETERS)
                .weight(String.valueOf(faker.number().numberBetween(30, 500)))
                .height(String.valueOf(faker.number().numberBetween(60, 240)))
                .age(String.valueOf(faker.number().numberBetween(5, 99)))
                .distance(String.valueOf(faker.number().numberBetween(1, 500)))
                .build();
    }

    public static PaceCalculator getPaceCalculatorInform() {
        return PaceCalculator.builder()
                .distanceType(DistanceType.KM)
                .distance(String.valueOf(faker.number().numberBetween(1, 9999)))
                .hours(String.valueOf(faker.number().numberBetween(0, 99)))
                .minutes(String.valueOf(faker.number().numberBetween(1, 59)))
                .seconds(String.valueOf(faker.number().numberBetween(1, 59)))
                .build();
    }
}