$(document).ready(function() {
    cargarDj();
    $('#djs').DataTable();
});

async function cargarDj() {
const request = await fetch('/listar', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  const djs = await request.json();

  let listadoHTML = '';
  for (let dj of djs) {
  let djHTML = '<tr><th scope="row">'+ dj.id + '</th><td>'+dj.nombre + '</td><td>'+dj.apellido + '</td><td>'+dj.genero + '</td></tr>'
  listadoHTML += djHTML;
  }
  document.querySelector("#djs tbody").outerHTML = listadoHTML;

}
document.addEventListener("keyup", e=>{

  if (e.target.matches("#buscador")){

      if (e.key ==="Escape")e.target.value = ""

      document.querySelectorAll(".articulo").forEach(elemento =>{

          elemento.textContent.toLowerCase().includes(e.target.value.toLowerCase())
            ?elemento.classList.remove("filtro")
            :elemento.classList.add("filtro")
      })

  }


})