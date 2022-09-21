package labno6
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class shiftregtest extends FreeSpec with ChiselScalatestTester{
    "lab6shiftreg" in{
        test (new shift_register() ){
            c=>
            c.io.in.poke(1.B)
             //c.io.state.poke(1.U)
            c.clock.step(1)
            c.io.out.expect(3.U)
        }
    }
}