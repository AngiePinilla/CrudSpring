function deletePerson(id) {
    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
      }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                url:"/delete/"+id,
                success: function(res) {
                    console.log(res);
                }
            })
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          ).then((result)=>{
            if (result.isConfirmed) {
                location.href="/listar";
            }

          })
        }
      })
}