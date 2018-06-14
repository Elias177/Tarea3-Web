
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="panel-group">
                <div class="panel panel-primary">
                    <div class="panel-heading">

                        <form class="col-11 py-5" method="post" action="/articulo/eliminar/${articulo.id}">

                            <div class="panel px-2 py-3 bg-white">
                                <p style="color: black;">¿Desea eliminar el artículo: <strong >${articulo.titulo}</strong>?</p>
                            </div>

                            <button class="btn btn-light"  type="submit">
                                ELIMINAR
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
