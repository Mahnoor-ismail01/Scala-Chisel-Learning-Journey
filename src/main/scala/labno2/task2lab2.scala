package labno2
import chisel3 . _
import chisel3 . util . _
class barrel_shift extends Module {
val io = IO ( new Bundle {
val in = Vec (4 , Input ( Bool () ) )
val sel = Vec (2 , Input ( Bool () ) )
val shift_type = Input ( Bool () )
val out = Vec (4 , Output ( Bool () ) )
})

val  Mux1=Mux(io.sel(1),Mux(io.sel(0),io.in(0),io.in(1)),Mux(io.sel(0),io.in(2),io.in(3)))
val mux2=Mux(io.sel(1),Mux(io.sel(0),io.in(0),io.in(1)),Mux(io.sel(0),Mux(io.shift_type,io.in(2),0.B),io.in(3)))
val mux3=Mux(io.sel(1),Mux(io.sel(0),io.in(0),io.in(1)),Mux(io.sel(0),Mux(io.shift_type,io.in(2),0.B),Mux(io.shift_type,io.in(3),0.B)))
val mux4=Mux(io.sel(1),Mux(io.sel(0),io.in(0),Mux(io.shift_type,io.in(2),0.B)),Mux(io.sel(0),Mux(io.shift_type,io.in(2),0.B),Mux(io.shift_type,io.in(3),0.B)))
io.out(0):=Mux1
io.out(1):=mux2
io.out(2):=mux3
io.out(3):=mux4
}