package SingleCycle
import chisel3._
import org.scalatest._
import chiseltest._
import chiseltest.internal.VerilatorBackendAnnotation
import chiseltest.experimental.TestOptionBuilder._
import scala.util.Random

class immediateTest extends FreeSpec with ChiselScalatestTester{
    "Imediate single cycle" in {
        test(new ImmdValGen2()){
            c=>
           val  array_ins=Array("h00918093")
            //array_l=Array(9)
            for (i<-0 until 100){
                //val src_a=Random.nextLong () & 0xFFFFFFFFL
                val opr = Random.nextInt(1)
                val aluop = array_ins(0)
            var result = aluop match{
                case "h00918093"=> 9
               
            }
           // c.io.instr.poke(aluop.S)
            c.clock.step(1)
           // c.io.immd_se.expect(result.U)
            }
        }
    }
}
