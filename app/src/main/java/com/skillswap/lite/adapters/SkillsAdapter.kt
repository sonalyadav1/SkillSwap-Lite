package com.skillswap.lite.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skillswap.lite.R
import com.skillswap.lite.models.Skill
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class SkillsAdapter(
    private var skills: List<Skill>,
    private val onContactClick: (Skill) -> Unit
) : RecyclerView.Adapter<SkillsAdapter.SkillViewHolder>() {

    class SkillViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.iv_profile)
        val userName: TextView = view.findViewById(R.id.tv_user_name)
        val skillTitle: TextView = view.findViewById(R.id.tv_skill_title)
        val skillDescription: TextView = view.findViewById(R.id.tv_skill_description)
        val chipGroup: ChipGroup = view.findViewById(R.id.chip_group_tags)
        val contactButton: Button = view.findViewById(R.id.btn_contact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_skill, parent, false)
        return SkillViewHolder(view)
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        val skill = skills[position]
        
        holder.userName.text = skill.userName
        holder.skillTitle.text = skill.title
        holder.skillDescription.text = skill.description
        
        // Load profile image
        if (skill.profileImageUrl.isNotEmpty()) {
            Glide.with(holder.itemView.context)
                .load(skill.profileImageUrl)
                .circleCrop()
                .placeholder(R.drawable.ic_profile_placeholder)
                .into(holder.profileImage)
        } else {
            holder.profileImage.setImageResource(R.drawable.ic_profile_placeholder)
        }
        
        // Clear and add tags
        holder.chipGroup.removeAllViews()
        skill.tags.forEach { tag ->
            val chip = Chip(holder.itemView.context)
            chip.text = tag
            chip.isClickable = false
            holder.chipGroup.addView(chip)
        }
        
        holder.contactButton.setOnClickListener {
            onContactClick(skill)
        }
    }

    override fun getItemCount(): Int = skills.size

    fun updateSkills(newSkills: List<Skill>) {
        skills = newSkills
        notifyDataSetChanged()
    }
}
