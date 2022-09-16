package labno5
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._

class clonetypetest extends FreeSpec with ChiselScalatestTester{
    "lab5ex4" in{
        test (new Top (18 , 30 , 32) ){
            c=>
            c.io.in.poke(1.U)
            c.clock.step(1)
            c.io.out.expect(1.U)
        }
    }
}