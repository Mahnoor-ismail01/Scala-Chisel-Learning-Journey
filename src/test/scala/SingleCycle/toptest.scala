package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class toptester extends FreeSpec with ChiselScalatestTester{
    "single Cycle Top test" in {
        test(new Top()).withAnnotations(Seq(VerilatorBackendAnnotation)){
            c=>
            c.clock.step(100)
        }
    }
}