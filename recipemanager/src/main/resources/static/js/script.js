// Optional: Add dynamic behavior (e.g., confirm before deletion)
document.addEventListener('DOMContentLoaded', function() {
    // Confirm before deleting a recipe
    const deleteButtons = document.querySelectorAll('.delete-btn');
    deleteButtons.forEach(button => {
        button.addEventListener('click', (e) => {
            if (!confirm('Are you sure you want to delete this recipe?')) {
                e.preventDefault();
            }
        });
    });
});