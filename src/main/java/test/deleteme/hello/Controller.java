package test.deleteme.hello;

import ca.vastier.depense.generated.model.Item;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller
{
	@RequestMapping("hello")
	public String hello()
	{
		final ServerRuntime cayenneRuntime = ServerRuntime.builder().addConfig("cayenne-project.xml").build();
		final ObjectContext context = cayenneRuntime.newContext();

		Item item = context.newObject(Item.class);
		item.setName("my favorite item");

		context.commitChanges();
		item = null;

		item = ObjectSelect.query(Item.class).select(context).get(0);

		return "hello, " + item.getId() + item.getName();
	}
}
