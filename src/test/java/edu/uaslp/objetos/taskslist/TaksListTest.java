package edu.uaslp.objetos.taskslist;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;

public class TaksListTest {

    @Test
    public void givenANewTasksList_whenCreated_thenListIsEmpty() {
        // Given: (Inicialización)
        ToDoList taskList = new ToDoList();

        // When: (Ejecución)
        int itemsCount = taskList.getSize();

        // Then: (Validación)
        assertThat(itemsCount).isZero();
    }

    @Test
    public void givenANewTask_validateInfoOnTask() {
        // Given:
        Task task = new Task();

        task.setTittle("Lavar los trastes");
        task.setDescription("Lavar los trastes sin tirar mucha agua");
        task.setDone(false);

        // When:
        String title = task.getTittle();
        String description = task.getDescription();
        LocalDateTime dueDate = task.getDueDate();
        boolean done = task.isDone();

        // Then:
        assertThat(title).isEqualTo("Lavar los trastes");
        assertThat(description).isEqualTo("Lavar los trastes sin tirar mucha agua");
        assertThat(dueDate).isNull();
        assertThat(done).isFalse();
    }

    @Test
    public void givenANewTask_validateInfoWithDueDateOnTask() {
        // Given:
        Task task = new Task();

        task.setTittle("Lavar los trastes");
        task.setDescription("Lavar los trastes sin tirar mucha agua");
        task.setDueDate(LocalDateTime.of(2021, Month.DECEMBER, 25, 0, 0, 0));
        task.setDone(false);

        // When:
        String title = task.getTittle();
        String description = task.getDescription();
        LocalDateTime dueDate = task.getDueDate();
        boolean done = task.isDone();

        // Then:
        assertThat(title).isEqualTo("Lavar los trastes");
        assertThat(description).isEqualTo("Lavar los trastes sin tirar mucha agua");
        assertThat(dueDate).isEqualTo(LocalDateTime.of(2021, Month.DECEMBER, 25, 0, 0, 0));
        assertThat(done).isFalse();
    }

    @Test
    public void givenANewTask_whenDueDateIsSetInThePast_thenAnExceptionIsThrown() {
        // Given:
        Task task = new Task();
        LocalDateTime dateInThePast = LocalDateTime.of(2021, Month.JANUARY, 25, 0, 0, 0);

        // When:
        // Then:
        assertThatThrownBy(() -> task.setDueDate(dateInThePast))
                .hasMessage("Due date is set in the past")
                .isInstanceOf(ToDoListException.class)
                .isInstanceOf(RuntimeException.class);

    }

}
