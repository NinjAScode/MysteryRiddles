namespace MysteryRiddles.Models
{
    using System;
    using System.Collections.Generic;
    using System.ComponentModel.DataAnnotations;
    using System.Linq;
    using System.Text;
    using System.Threading.Tasks;

    public class Riddle : AuditInfo, IAuditInfo
    {
        public int Id { get; set; }
        
        [Required]
        [StringLength(200), MinLength(5)]
        public string Title { get; set; }

        [Required]
        [MinLength(10)]
        public string Description { get; set; }

        [Required]
        [MinLength(10)]
        public string Answer { get; set; }

        public string AuthorId { get; set; }

        public virtual User Author { get; set; }
    }
}