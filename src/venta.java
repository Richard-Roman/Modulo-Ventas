import java.util.*;

public class venta {
    private Scanner Sc = new Scanner(System.in);
    
    private String ID, FechaEmicion,  Observaciones;
    private double total;
    public cliente c = new cliente();
    private vendedor vendedor = new vendedor();
    private Set<detalleVenta> Registventa = new LinkedHashSet<>();

    public String getID() {
        return ID;
    }
    public String getFechaEmicion() {
        return FechaEmicion;
    }
    public String getObservaciones() {
        return Observaciones;
    }
    public Set<detalleVenta> getRegistventa() {
        return Registventa;
    }
    public double getTotal() {
        return total;
    }
    public cliente getCliente() {
        return c;
    }
    public vendedor getVendedor() {
        return vendedor;
    }

    public void setID(String iD) {
        ID = iD;
    }
    public void setFechaEmicion(String fechaEmicion) {
        FechaEmicion = fechaEmicion;
    }
    public void setObservaciones(String observaciones) {
        Observaciones = observaciones;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public void setCliente(cliente cliente) {
        this.c = cliente;
    }
    public void setVendedor(vendedor vendedor) {
        this.vendedor = vendedor;
    }



    public void LlenarProductos(){
        boolean terminar = false;
        Sc.useDelimiter("\\s+");
       
        System.out.println("|id | Nombre  |P.Unit| Cantidad |");
        System.out.println("----------------------------------------------------------------------");
        do{
            System.out.print("  ");
            producto producto = new producto();
            detalleVenta dt = new detalleVenta();
            String control = Sc.next();
            if (!control.equals("terminar")){
                int id = Integer.parseInt(control);
                String nombre = Sc.next();
                double precio = Sc.nextDouble(); 
                double cantidad = Sc.nextDouble(); 
                producto.setIdProducto(id);producto.setNombre(nombre); producto.setPrecio(precio);
                dt.setProducto(producto);dt.setCantidad(cantidad);
                this.Registventa.add(dt);
            }else{
                terminar=true;
            }

        }while(!terminar);
     }
    public void LlenarVenta(){
        System.out.println("----------------------------------------------------------------------");
        setID(leer.Cadena("                      Venta N°"));
        System.out.println("----------------------------------------------------------------------");
        setFechaEmicion(leer.Cadena("                                          Fecha"));
        String nombre = leer.Cadena("Señor(es)      ");
        String Tipoid = leer.Cadena("Tipo Documento ");
        Integer id = leer.Entero("N° "+Tipoid+" ");
        System.out.println("----------------------------------------------------------------------");
        LlenarProductos();
        System.out.println("----------------------------------------------------------------------");

        this.c.setNombre(nombre);this.c.setTipoId(Tipoid); this.c.setId(id);
    }


    public void CompovarVenta(){

    }

    public void EditarVenta(){
        

    }


    public void MostrarError(){

    }

    public void MostrarVenta(){
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                      Venta N° "+getID());
        System.out.println("----------------------------------------------------------------------");
        System.out.println("                                          Fecha: "+getFechaEmicion());
        System.out.println("Señor(es)      "+ this.c.getNombre());
        System.out.println("Tipo Documento "+ this.c.getTipoId());
        if(c.tieneRuc()){
            System.out.println("N° RUC: "+ this.c.getId());
        }else{
            System.out.println("N° DNI: "+ this.c.getId());
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|id  | Nombre   | P.Unit | Cantidad |");
        System.out.println("----------------------------------------------------------------------");
        
        for (detalleVenta dt: Registventa){
            dt.mostrarDetalle();
        }
        System.out.println("----------------------------------------------------------------------");
    }
    
    public static void main(String[] args) {
        venta venta = new venta();
        venta.LlenarVenta();
        venta.MostrarVenta();
    }

}

