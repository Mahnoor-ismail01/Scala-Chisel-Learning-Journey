package labno5
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class ParamAdder extends FreeSpec with ChiselScalatestTester{
    "lab5task3" in{
        test (new AdderparamWidth(2) ){
            c=>
            c.io.in1.poke(1.U)
             c.io.in2.poke(1.U)
            c.clock.step(1)
            c.io.out.expect(2.U)
        }
    }
}