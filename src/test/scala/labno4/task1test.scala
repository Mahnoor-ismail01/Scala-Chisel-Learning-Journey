package labno4
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random

class TestBranch (c:BranchControl1) extends FreeSpec with ChiselScalatestTester{
    "Branchtest" in {
        test(new BranchControl1()){
            c=>
            val array_func=Array("b001","b000")
            
        for (i<-0 until 100){
            val src_a = Random.nextLong () & 0xFFFFFFFFL
            val src_b = Random.nextLong () & 0xFFFFFFFFL
            
            val opr = Random.nextInt(2)
            val aluop = array_func(opr)
            val bar=Random.nextBoolean()
        
        var result= aluop match{
            case "b001"  =>src_a!=src_b
            case "b000" =>src_a===src_b
            case _ => 0

        }
        var result1 = bar match{
            case true => result
            case false => false
        }
       

c . io . in_A . poke ( src_a . U )
c . io . in_B . poke ( src_b . U )
c.io .funct3.poke( aluop.U )
//c.io.branch.poke(branch.B)
c . clock . step (1)
c.io.out.expect(result1.asInstanceOf[Bool])
        }
        c . clock . step (2)
    }
}
}