package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._
 class AluControltest extends FreeSpec with ChiselScalatestTester{
     "alu control single cycle" in {
         test(new AlU_Control()){
             c=>
             c.io.AluOp.poke(0.U)
             c.io.func7.poke(0.B)
        c.io.func3.poke(0.U)
        c.clock.step(1)
        c.io.AluControl.expect(0.U)
         }
     }
 }