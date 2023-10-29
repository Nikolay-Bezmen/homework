package edu.hw4;

import jakarta.validation.ConstraintViolation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.Set;
import static edu.hw4.Task19.Animal.Sex.M;
import static edu.hw4.Task19.Animal.Type.BIRD;
import static edu.hw4.Task19.Animal.Type.CAT;
import static edu.hw4.Task19.Animal.Type.DOG;
import static edu.hw4.Task19.Animal.Type.FISH;
import static edu.hw4.Task19.Animal.Type.SPIDER;
import static edu.hw4.Task19.Animal.deleteAnimals;
import static edu.hw4.Task19.Animal.getErrorsCreate;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import edu.hw4.Task19.Animal;


public class Task19Test {
    private final static Logger LOGGER = LogManager.getLogger();

    @Nested class check_age_valid{
        @Test
        void check_dog_invalid_age_validate(){
            deleteAnimals();
            Animal dog1 = new Animal("Sharik", DOG, M, 51, 15, 15, true);
            Animal dog2 = new Animal("Barbos", DOG, M, 54, 15, 15, true);
            Animal dog3 = new Animal("Bobik", DOG, M, 56, 15, 15, true);
            String errorMessage = "Dog's age must be between 0 and 35";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_cat_invalid_age_validate(){
            deleteAnimals();
            Animal cat1 = new Animal("CAT1", CAT, M, 41, 15, 15, true);
            Animal cat2 = new Animal("CAT2", CAT, M, 78763, 15, 15, true);
            Animal cat3 = new Animal("CAT3", CAT, M, 49, 15, 15, true);
            String errorMessage = "Cat's age must be between 0 and 40";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_fish_invalid_age_validate(){
            deleteAnimals();
            Animal fish1 = new Animal("CAT1", FISH, M, 61, 15, 15, true);
            Animal fish2 = new Animal("CAT2", FISH, M, 4492, 15, 15, true);
            Animal fish3 = new Animal("CAT3", FISH, M, 98, 15, 15, true);
            String errorMessage = "Fish's age must be between 0 and 60";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_bird_invalid_age_validate(){
            deleteAnimals();
            Animal bird1 = new Animal("BIRD1", BIRD, M, 180, 15, 15, true);
            Animal bird2 = new Animal("BIRD2", BIRD, M, 400, 15, 15, true);
            Animal bird3 = new Animal("BIRD3", BIRD, M, 1000, 15, 15, true);
            String errorMessage = "Bird's age must be between 0 and 150";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_spider_invalid_age_validate(){
            deleteAnimals();
            Animal spider1 = new Animal("SPIDER1", SPIDER, M, 180, 0, 0, true);
            Animal spider2 = new Animal("SPIDER2", SPIDER, M, 151, 0, 0, true);
            Animal spider3 = new Animal("SPIDER3", SPIDER, M, 9195, 0, 0, true);
            String errorMessage = "Spider's age must be between 0 and 150";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }
    }
    @Nested class check_weight_valid{
        @Test
        void check_dog_invalid_weight_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal dog1 = new edu.hw4.Task19.Animal("Sharik", DOG, M, 17, 15, 155, true);
            edu.hw4.Task19.Animal dog2 = new edu.hw4.Task19.Animal("Barbos", DOG, M, 22, 15, 87874, true);
            edu.hw4.Task19.Animal dog3 = new edu.hw4.Task19.Animal("Bobik", DOG, M, 26, 15, -898, true);
            String errorMessage = "Dog's weight must be between 0 and 150";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_cat_invalid_weight_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal cat1 = new edu.hw4.Task19.Animal("CAT1", CAT, M, 29, 15, 345, true);
            edu.hw4.Task19.Animal cat2 = new edu.hw4.Task19.Animal("CAT2", CAT, M, 7, 15, 89752, true);
            edu.hw4.Task19.Animal cat3 = new edu.hw4.Task19.Animal("CAT3", CAT, M, 37, 15, -1, true);
            String errorMessage = "Cat's weight must be between 0 and 300";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_fish_invalid_weight_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal fish1 = new edu.hw4.Task19.Animal("FISH1", FISH, M, 59, 15, 30001, true);
            edu.hw4.Task19.Animal fish2 = new edu.hw4.Task19.Animal("FISH2", FISH, M, 44, 15, 848348, true);
            edu.hw4.Task19.Animal fish3 = new edu.hw4.Task19.Animal("FISH3", FISH, M, 9, 15, -1, true);
            String errorMessage = "Fish's weight must be between 0 and 30000";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_bird_invalid_weight_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal bird1 = new edu.hw4.Task19.Animal("BIRD1", BIRD, M, 10, 15, 1555, true);
            edu.hw4.Task19.Animal bird2 = new edu.hw4.Task19.Animal("BIRD2", BIRD, M, 40, 15, 187, true);
            edu.hw4.Task19.Animal bird3 = new edu.hw4.Task19.Animal("BIRD3", BIRD, M, 117, 15, -1, true);
            String errorMessage = "Bird's weight must be between 0 and 160";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_spider_invalid_weight_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal spider1 = new edu.hw4.Task19.Animal("SPIDER1", SPIDER, M, 18, 0, 3, true);
            edu.hw4.Task19.Animal spider2 = new edu.hw4.Task19.Animal("SPIDER2", SPIDER, M, 15, 0, 4, true);
            edu.hw4.Task19.Animal spider3 = new edu.hw4.Task19.Animal("SPIDER3", SPIDER, M, 90, 0, -1, true);
            String errorMessage = "Spider's weight must be between 0 and 2";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }
    }
    @Nested class check_height_valid{
        @Test
        void check_dog_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal dog1 = new edu.hw4.Task19.Animal("Sharik", DOG, M, 17, -199, 0, true);
            edu.hw4.Task19.Animal dog2 = new edu.hw4.Task19.Animal("Barbos", DOG, M, 22, 139, 0, true);
            edu.hw4.Task19.Animal dog3 = new edu.hw4.Task19.Animal("Bobik", DOG, M, 26, 200, 0, true);
            String errorMessage = "Dog's height must be between 0 and 120";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_cat_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal cat1 = new edu.hw4.Task19.Animal("CAT1", CAT, M, 29, 67, 0, true);
            edu.hw4.Task19.Animal cat2 = new edu.hw4.Task19.Animal("CAT2", CAT, M, 7, -1, 0, true);
            edu.hw4.Task19.Animal cat3 = new edu.hw4.Task19.Animal("CAT3", CAT, M, 37, 109, 0, true);
            String errorMessage = "Cat's height must be between 0 and 50";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_fish_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal fish1 = new edu.hw4.Task19.Animal("FISH1", FISH, M, 0,90952,  0, true);
            edu.hw4.Task19.Animal fish2 = new edu.hw4.Task19.Animal("FISH2", FISH, M, 0,-999,  0, true);
            edu.hw4.Task19.Animal fish3 = new edu.hw4.Task19.Animal("FISH3", FISH, M, 0,5001, 0, true);
            String errorMessage = "Fish's height must be between 0 and 5000";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_bird_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal bird1 = new edu.hw4.Task19.Animal("BIRD1", BIRD, M, 10, 888, 0, true);
            edu.hw4.Task19.Animal bird2 = new edu.hw4.Task19.Animal("BIRD2", BIRD, M, 40, -90, 0, true);
            edu.hw4.Task19.Animal bird3 = new edu.hw4.Task19.Animal("BIRD3", BIRD, M, 117, 999, 0, true);
            String errorMessage = "Bird's height must be between 0 and 360";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_spider_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal spider1 = new edu.hw4.Task19.Animal("SPIDER1", SPIDER, M, 18, 56, 0, true);
            edu.hw4.Task19.Animal spider2 = new edu.hw4.Task19.Animal("SPIDER2", SPIDER, M, 15, -5326, 0, true);
            edu.hw4.Task19.Animal spider3 = new edu.hw4.Task19.Animal("SPIDER3", SPIDER, M, 90, 88, 0, true);
            String errorMessage = "Spider's height must be between 0 and 50";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }
    }
    @Nested class check_bites_valid{
        @Test
        void check_dog_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal dog1 = new edu.hw4.Task19.Animal("Sharik", DOG, M, 17, 0, 0, false);
            edu.hw4.Task19.Animal dog2 = new edu.hw4.Task19.Animal("Barbos", DOG, M, 22, 0, 0, false);
            edu.hw4.Task19.Animal dog3 = new edu.hw4.Task19.Animal("Bobik", DOG, M, 26, 0, 0, false);
            String errorMessage = "Dog's must be bites";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_cat_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal cat1 = new edu.hw4.Task19.Animal("CAT1", CAT, M, 29, 0, 0, false);
            edu.hw4.Task19.Animal cat2 = new edu.hw4.Task19.Animal("CAT2", CAT, M, 7, 0, 0, false);
            edu.hw4.Task19.Animal cat3 = new edu.hw4.Task19.Animal("CAT3", CAT, M, 37, 0, 0, false);
            String errorMessage = "Cat's must be bites";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }

        @Test
        void check_bird_invalid_height_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal bird1 = new edu.hw4.Task19.Animal("BIRD1", BIRD, M, 10, 0, 0, false);
            edu.hw4.Task19.Animal bird2 = new edu.hw4.Task19.Animal("BIRD2", BIRD, M, 40, 0, 0, false);
            edu.hw4.Task19.Animal bird3 = new edu.hw4.Task19.Animal("BIRD3", BIRD, M, 117, 0, 0, false);
            String errorMessage = "Bird's must be bites";

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();

            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(1);
                for(var viol: entry.getValue()){
                    assertThat(viol.getMessage()).isEqualTo(errorMessage);
                }
            }
        }
    }
    @Nested class check_if_all_parameters_is_valid{
        @Test
        void check_dog_valid_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal dog1 = new edu.hw4.Task19.Animal("Sharik", DOG, M, 13, 15, 15, true);
            edu.hw4.Task19.Animal dog2 = new edu.hw4.Task19.Animal("Barbos", DOG, M, 19, 15, 15, true);
            edu.hw4.Task19.Animal dog3 = new edu.hw4.Task19.Animal("Bobik", DOG, M, 34, 15, 15, true);

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(0);
            }
        }
        @Test
        void check_bird_valid_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal bird1 = new edu.hw4.Task19.Animal("BIRD1", BIRD, M, 18, 15, 15, true);
            edu.hw4.Task19.Animal bird2 = new edu.hw4.Task19.Animal("BIRD2", BIRD, M, 40, 15, 15, true);
            edu.hw4.Task19.Animal bird3 = new edu.hw4.Task19.Animal("BIRD3", BIRD, M, 1, 15, 15, true);

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(0);
            }
        }
        @Test
        void check_spider_valid_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal spider1 = new edu.hw4.Task19.Animal("SPIDER1", SPIDER, M, 18, 0, 0, true);
            edu.hw4.Task19.Animal spider2 = new edu.hw4.Task19.Animal("SPIDER2", SPIDER, M, 40, 0, 0, true);
            edu.hw4.Task19.Animal spider3 = new edu.hw4.Task19.Animal("SPIDER3", SPIDER, M, 1, 0, 0, true);

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(0);
            }
        }
        @Test
        void check_fish_valid_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal fish1 = new edu.hw4.Task19.Animal("CAT1", FISH, M, 18, 15, 15, true);
            edu.hw4.Task19.Animal fish2 = new edu.hw4.Task19.Animal("CAT2", FISH, M, 40, 15, 15, true);
            edu.hw4.Task19.Animal fish3 = new edu.hw4.Task19.Animal("CAT3", FISH, M, 1, 15, 15, true);

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(0);
            }
        }

        @Test
        void check_cat_valid_validate(){
            deleteAnimals();
            edu.hw4.Task19.Animal cat1 = new edu.hw4.Task19.Animal("CAT1", CAT, M, 18, 15, 15, true);
            edu.hw4.Task19.Animal cat2 = new edu.hw4.Task19.Animal("CAT2", CAT, M, 40, 15, 15, true);
            edu.hw4.Task19.Animal cat3 = new edu.hw4.Task19.Animal("CAT3", CAT, M, 1, 15, 15, true);

            Map<String, Set<ConstraintViolation<edu.hw4.Task19.Animal>>> validateErrors = getErrorsCreate();
            assertThat(validateErrors.size()).isEqualTo(3);
            for(var entry: validateErrors.entrySet()){
                assertThat(entry.getValue().size()).isEqualTo(0);
            }
        }
    }
}
