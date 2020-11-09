import {NgModule} from "@angular/core";
import {TestComponent} from "./test.component";
import {TestRoutingModule} from "./test-routing.module";

@NgModule(
  {
    declarations: [TestComponent],
    exports: [TestComponent],
    bootstrap: [TestComponent],
    imports: [TestRoutingModule]
  }
)
export class TestModule {

}
