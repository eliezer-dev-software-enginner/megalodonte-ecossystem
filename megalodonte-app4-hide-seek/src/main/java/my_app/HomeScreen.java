package my_app;

import megalodonte.base.components.Component;
import megalodonte.base.components.ScreenComponent;
import megalodonte.base.state.State;
import megalodonte.components.Button;
import megalodonte.components.Text;
import megalodonte.components.layout_components.Container;
import megalodonte.props.ContainerProps;
import megalodonte.v2.Show;

public class HomeScreen implements ScreenComponent {
    State<Boolean> isVisible = new State<>(false);

    @Override
    public Component render() {
      return new Container(new ContainerProps().paddingAll(25))
              .children(
                      new Button("Hide and seek - game").onClick(this::toggleVisibility),
                      Show.when(isVisible, ()-> new Text("You catch me"))
                      );
    }

    void toggleVisibility(){
        isVisible.set(!isVisible.get());
    }
}
