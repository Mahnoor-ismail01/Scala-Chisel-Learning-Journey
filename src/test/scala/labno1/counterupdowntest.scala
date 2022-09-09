package labno1
import chiseltest._
import chisel3._
import org.scalatest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._
class testcounter_up_down1 extends FreeSpec with ChiselScalatestTester{
  "testlab2" in {
    test(new counter_up_down(3)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
     
      c.clock.step(100)
    }
  }
}