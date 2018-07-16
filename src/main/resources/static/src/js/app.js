let reviewItem = document.querySelectorAll('review-items > li');
const tags = document.querySelector('.tags-items');
tags.addEventListener('click', removeTag);

function removeTag(event) {
    if (event.target.classList.contains('delete')) {
        const deleteButton = event.target;
        
    }
}

let reviewText = reviewItem.textContent;

console.log(reviewText);

const tags = document.querySelector('.tags');