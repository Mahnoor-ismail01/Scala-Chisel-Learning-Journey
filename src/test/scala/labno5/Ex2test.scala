package labno5
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class emuxbundle extends FreeSpec with ChiselScalatestTester{
    "labno5task2" in {
        test(new Mux2_to_1(2.U)){
            c=>
            c.io.in1.poke(1.U)
            c.io.in2.poke(0.U)
            c.io.sel.poke(1.B)
            c.clock.step(1)
            c.io.out.expect(1.U)
        }
    }
}