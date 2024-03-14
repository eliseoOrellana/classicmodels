// Esperar 5 segundos antes de ocultar el mensaje
setTimeout(function() {
    var messageElement = document.getElementById("message");
    messageElement.classList.add("hide");
}, 5000); // 5000 milisegundos = 5 segundos



document.querySelectorAll('.deleteLink').forEach(function(link) {
    link.addEventListener('click', function(event) {
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
                window.location.href = this.getAttribute('href');
            }
        });
    });
});

document.querySelectorAll('.softDeleteLink').forEach(function(link) {
    link.addEventListener('click', function(event) {
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
                // Si el usuario confirma, se redirige al enlace de soft delete
                window.location.href = this.getAttribute('href');
            }
        });
    });
});