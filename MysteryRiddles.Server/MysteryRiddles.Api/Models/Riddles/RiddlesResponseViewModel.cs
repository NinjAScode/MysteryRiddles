namespace MysteryRiddles.Models.Riddles
{
    using MysteryRiddles.Api.Mapping;
    using System;
    using System.ComponentModel.DataAnnotations;
    using AutoMapper;

    public class RiddlesResponseViewModel : IMapFrom<Riddle>, IHaveCustomMappings
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

        public string AuthorName { get; set; }

        public DateTime CreatedOn { get; set; }

        public void CreateMappings(IConfiguration configuration)
        {
            configuration.CreateMap<Riddle, RiddlesResponseViewModel>()
               .ForMember(r => r.AuthorName, opt => opt.MapFrom(x => x.Author.UserName));
        }
    }
}