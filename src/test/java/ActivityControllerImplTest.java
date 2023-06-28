import com.raparison.desktop.controller.ActivityController;
import com.raparison.desktop.controller.ActivityControllerImpl;
import com.raparison.desktop.model.Activity;
import com.raparison.desktop.repository.ActivityRepositoryImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Date;

import static com.mongodb.assertions.Assertions.fail;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Group of units tests for the activity controller")
public class ActivityControllerImplTest {

    @Mock
    ActivityRepositoryImpl activityRepository;
    ActivityController activityController = new ActivityController() {
        @Override
        public String saveActivity(Activity activity) {
            return null;
        }

        @Override
        public int calculateCharge(int duration, int RPE) {
            return 0;
        }
    };

    Activity christineActivity = new Activity(
            "Christine",
            20,
            new Date(1982, 1, 1),
            5,
            activityController);
    Activity brokenActivity = new Activity(
            "Christine",
            15,
            new Date(2082, 1, 1),
            4,
            activityController);

    String id = "idChristine";

    ActivityControllerImpl classUnderTest;

    @BeforeEach
    public void setUp () {

        classUnderTest = new ActivityControllerImpl(activityRepository);
    }

    @Disabled
    @Test
    @DisplayName("Test an action")
    public void voidAction_isTested_shouldFail () {

        fail("Not yet implemented");
    }

    @Test
    @DisplayName("Test if the save method of the repository is called with an Activity")
    public void save_withActivity_shouldCallRepository () {
        //Arrange
        when(activityRepository.save(christineActivity)).thenReturn(id);

        //Act
        String result = classUnderTest.saveActivity(christineActivity);

        //Assert
        verify(activityRepository).save(christineActivity);
        verify(activityRepository).save(any(Activity.class));
        verify(activityRepository, times(1))
                .save(any(Activity.class));
        verify(activityRepository, never()).getAll();
        assertThat(result).isEqualTo(id);
    }

    @Test
    public void testChargeCalculation() {

    }
}
