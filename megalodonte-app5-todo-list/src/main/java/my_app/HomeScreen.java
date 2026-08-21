package my_app;

import megalodonte.ForEachState;
import megalodonte.base.components.Component;
import megalodonte.base.components.ScreenComponent;
import megalodonte.components.Button;
import megalodonte.components.SpacerHorizontal;
import megalodonte.components.SpacerVertical;
import megalodonte.components.Text;
import megalodonte.components.layout_components.Column;
import megalodonte.components.layout_components.Container;
import megalodonte.components.layout_components.Row;
import megalodonte.props.ColumnProps;
import megalodonte.props.ContainerProps;
import megalodonte.v2.ListState;

import java.util.List;
import java.util.function.Consumer;

public class HomeScreen implements ScreenComponent {
    ListState<String> tasks = ListState.of(List.of("First","Second","Three","Four"));

    @Override
    public Component render() {
        Consumer<String> handleClickRemove = (task)->{
          tasks.remove(task);
        };

        var tasksForEachState = ForEachState.of(
          tasks, task-> new Row().children(
                        new Text(task),
                        new SpacerHorizontal(15),
                        new Button("Remove").onClick(()-> handleClickRemove.accept(task))
                )
        );

      return new Container(new ContainerProps().paddingAll(20)).children(
              new Text("Your tasks below"),
              new SpacerVertical(20),
              new Column().items(tasksForEachState, 30)
      );
    }
}
