// Esperar 5 segundos antes de ocultar el mensaje
setTimeout(function() {
    var messageElement = document.getElementById("message");
    messageElement.classList.add("hide");
}, 5000); // 5000 milisegundos = 5 segundos



document.getElementById('DeleteLink').addEventListener('click', function(event) {
    event.preventDefault(); // Prevenir que el enlace se ejecute automáticamente
    
    Swal.fire({
        title: 'Are you sure?',
        text: 'Are you sure you want to delete this employee permanently?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, delete it!',
        cancelButtonText: 'Cancel'
    }).then((result) => {
        if (result.isConfirmed) {
            // Si el usuario confirma, se redirige al enlace de eliminación
            window.location.href = event.target.href;
        }
    });
});


document.getElementById('softDeleteLink').addEventListener('click', function(event) {
    event.preventDefault(); // Prevenir que el enlace se ejecute automáticamente
    
    Swal.fire({
        title: 'Are you sure?',
        text: 'Are you sure you want to soft delete this employee?',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Yes, soft delete it!',
        cancelButtonText: 'Cancel'
    }).then((result) => {
        if (result.isConfirmed) {
            // Si el usuario confirma, se redirige al enlace de eliminación
            window.location.href = event.target.href;
        }
    });
});