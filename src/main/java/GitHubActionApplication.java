import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(
        tags = {
                @Tag(name="testing deploy", description="Endpoints about deploy"),
        },
        components = @Components(schemas = @Schema(title = "Buyable")
        ),
        info = @Info(
                title="github Actions API",
                version = "1.0.0"
        )
)
public class GitHubActionApplication extends Application {
}
